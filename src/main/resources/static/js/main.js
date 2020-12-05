let state = {
	vacation: {
		content: [],
		count: {
			total: 0,
			complete: 0,
		},
	}
}

$(document).ready(() => {

	$.ajax({
		type: "GET",
		url: "/api/1.0/vacations/",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: (response) => {
			state.vacation.content = response.content;
			state.vacation.count.total = response.totalElements;
			const cVacation = state.vacation.content.filter(i => i.status === "COMPLETED");
			state.vacation.count.complete = cVacation.length;
			document.querySelector("#completeCount").textContent = state.vacation.count.complete;
			document.querySelector(".list-group-item.list-group-item-action.active").querySelector("span").textContent = state.vacation.count.complete;
			document.querySelectorAll(".userUnit").forEach(item => {
				item.textContent = convertEngToKor(item.textContent);
				
			})
			
		}
	})
	console.log(state);
});

const onClickSendSmsBtn = (event) => {
	const username = event.target.parentNode.dataset.id;
	$.ajax({
		type: "POST",
		url: "/message/" + username,
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: (response) => {
			alert("해당 병사 부모님께 메시지 전송하였습니다.");
			event.target.disabled = true;
		}
	})
}

const onClickCameBackBtn = (event) => {
	const item = event.target.parentNode;
	const username = item.dataset.id;
	$.ajax({
		type: "PUT",
		url: "/api/1.0/vacations/" + username,
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: (response) => {
			state.vacation.count.complete += 1;
			document.querySelector("#completeCount").textContent = state.vacation.count.complete;
			document.querySelector(".list-group-item.list-group-item-action.active").querySelector("span").textContent = state.vacation.count.complete;
			item.parentNode.querySelector(".status").textContent = "✅";
			event.target.textContent = "SMS 전송";
			event.target.onclick = onClickSendSmsBtn;
		}
	})
}

const renderMain = (event) => {
	const target = event.target.closest(".list-group-item");
	document.querySelectorAll(".list-group-item").forEach(i => i.classList.remove("active"));
	target.classList.add("active");
	
	const unit = target.dataset.unit.trim();
	$.ajax({
		type: "GET",
		url: "/api/1.0/vacations?mine=false&unit=" + unit.replaceAll(" ", "_"),
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: (response) => {
			const markup = `
			<h2>${convertEngToKor(unit)} 복귀현황</h2>          
			<h5 class="text-right"><small class="text-muted">(복귀인원)</small><span id="completeCount">%복귀인원%</span>/${response.totalElements}<small class="text-muted">(총 복귀 예정인원)</small></h5>
	  		<table class="table table-striped">
		    	<thead>
		      		<tr>
				        <th>군번</th>
				        <th>계급</th>
				        <th>이름</th>
				        <th>전화번호</th>
				        <th>부모님 전화번호</th>
				        <th>휴가 출발</th>
				        <th>휴가 복귀</th>
				        <th>복귀 유무</th>
				        <th>비고</th>
		      		</tr>
		    	</thead>
		    <tbody>
		    ${response.content.map(item => {
				return `
			<tr>
		        <td>${item.user.username}</td>
		        <td>${item.user.ranks}</td>		        
		        <td>${item.user.name}</td>
		        <td>${item.user.phone}</td>
		        <td>${item.user.parentsPhone}</td>
		        <td>${item.checkIn}</td>
		        <td>${item.checkOut}</td>
		        <td class="status">${item.status === 'COMPLETED' ? "✅" : "❌"}</td>
		        <td data-id="${item.user.username}"><button onclick="${item.status === 'COMPLETED' ? 'onClickSendSmsBtn(event)">SMS 전송' : 'onClickCameBackBtn(event)">복귀 확인'}</button></td>
	        </tr>`
			}).join("")}
		    </tbody>
		  </table>`;
			document.querySelector(".content").innerHTML = markup;

			state = {
				vacation: {
					content: [],
					count: {
						total: 0,
						complete: 0,
					},
				}
			}
			state.vacation.content = response.content;
			state.vacation.count.total = response.totalElements;
			const cVacation = state.vacation.content.filter(i => i.status === "COMPLETED");
			state.vacation.count.complete = cVacation.length;
			document.querySelector("#completeCount").textContent = state.vacation.count.complete;
			document.querySelector(".list-group-item.list-group-item-action.active").querySelector("span").textContent = state.vacation.count.complete;
		}
	})

}

const convertEngToKor = (string) => {
	return string.replace("div", "사단").replace("r", "연대").replace("bn", "대대").replace("co", "중대");
}
const convertKorToEng = (string) => {
	return string.replace("사단", "div").replace("연대", "r").replace("대대", "bn").replace("중대", "co");
}
