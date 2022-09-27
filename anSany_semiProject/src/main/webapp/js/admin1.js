$("#modifyMember").on("click", function() {
	location.href = "/search.do";
});
$(".searchBtn").on("click", function() {
	$(".foundMember").show();
});

$(".changeLevel").on("click", function() {
	const memberNo = $(this).parent().parent().children().eq(1).text();
	const memberLevel = $(this).parent().prev().children().val();
	location.href = "/changeLevel.do?memberNo=" + memberNo + "&memberLevel=" + memberLevel;

});

$(".searchBtn").on("click", function() {
	const result = $(".result");
	result.empty();
	result.show();
	const searchCate = $(this).parent().parent().children().eq(0).children().val();
	const searchInput = $(this).parent().prev().children().val();
	if (searchCate == "noCate") {
		alert("조회분류를 선택해주세요");
		return;
	}
	$.ajax({
		url: "searchMember.do",
		type: "get",
		data: { searchCate: searchCate, searchInput: searchInput },
		dataType: "json",
		success: function(data) {
			const tr = $("<tr></tr>");
			const th1 = $("<th></th>");
			const th2 = $("<th></th>");
			const th3 = $("<th></th>");
			const th4 = $("<th></th>");
			const th5 = $("<th></th>");
			const th6 = $("<th></th>");
			const th7 = $("<th></th>");
			const th8 = $("<th></th>");
			const th9 = $("<th></th>");
			const th10 = $("<th></th>");
			th1.attr("scope", "col");
			th2.attr("scope", "col");
			th3.attr("scope", "col");
			th4.attr("scope", "col");
			th5.attr("scope", "col");
			th6.attr("scope", "col");
			th7.attr("scope", "col");
			th8.attr("scope", "col");
			th9.attr("scope", "col");
			th10.attr("scope", "col");
			th1.append("회원번호");
			th2.append("회원아이디");
			th3.append("이름");
			th4.append("생년월일");
			th5.append("전화번호");
			th6.append("주소");
			th7.append("이메일");
			th8.append("가입일");
			th9.append("회원등급");
			th10.append("등급변경");
			tr.append(th1);
			tr.append(th2);
			tr.append(th3);
			tr.append(th4);
			tr.append(th5);
			tr.append(th6);
			tr.append(th7);
			tr.append(th8);
			tr.append(th9);
			tr.append(th10);
			result.append(tr);
			for (let i = 0; i < data.length; i++) {
				const tr = $("<tr></tr>");
				const td1 = $("<td></td>");
				const td2 = $("<td></td>");
				const td3 = $("<td></td>");
				const td4 = $("<td></td>");
				const td5 = $("<td></td>");
				const td6 = $("<td></td>");
				const td7 = $("<td></td>");
				const td8 = $("<td></td>");
				const td9 = $("<td></td>");
				const td10 = $("<td></td>");
				const button = $("<button></button>");
				button.addClass("btn btn-outline-dark levelChange");
				button.append("등급변경");

				const select = $("<select></select>");
				select.addClass("btn btn-outline-dark");
				const option1 = $("<option></option>");
				const option2 = $("<option></option>");
				const option3 = $("<option></option>");
				option1.attr("value", "1");
				option2.attr("value", "2");
				option3.attr("value", "3");
				option1.append("관리자");
				option2.append("정회원");
				option3.append("준회원");


				td1.append(data[i].memberNo);
				td2.append(data[i].memberId);
				td3.append(data[i].memberName);
				td4.append(data[i].memberBirth);
				td5.append(data[i].memberPhone);
				td6.append(data[i].memberAddr);
				td7.append(data[i].memberEmail);
				td8.append(data[i].enrollDate);

				if (data[i].memberLevel == 1) {
					option1.attr("selected", "selected");
					select.append(option1);
					select.append(option2);
					select.append(option3);
					td9.append(select);
				}
				if (data[i].memberLevel == 2) {
					option2.attr("selected", "selected");
					select.append(option1);
					select.append(option2);
					select.append(option3);
					td9.append(select);
				}
				if (data[i].memberLevel == 3) {
					option3.attr("selected", "selected");
					select.append(option1);
					select.append(option2);
					select.append(option3);
					td9.append(select);
				}

				td10.append(button);
				tr.append(td1);
				tr.append(td2);
				tr.append(td3);
				tr.append(td4);
				tr.append(td5);
				tr.append(td6);
				tr.append(td7);
				tr.append(td8);
				tr.append(td9);
				tr.append(td10);
				result.append(tr);
			}


		},

		error: function() {
			console.log("조회 실패");
		}

	});

});

$(document).on("click", ".levelChange", function() {
	const memberNo = $(this).parent().parent().children().eq(0).text();
	const memberLevel = $(this).parent().prev().children().val();
	location.href = "/levelChange.do?memberNo=" + memberNo + "&memberLevel=" + memberLevel;
});

$(".chkedChange").on("click", function() {
	const check = $(".chk:checked");
	if (check.length == 0) {
		alert("선택된 회원이 없습니다.");
		return;
	}
	// 체크된 회원 번호 저장할 배열
	const no = new Array();
	// 체크된 회원 등급 저장할 배열
	const level = new Array();
	check.each(function(index, item) {
		const memberNo = $(item).parent().next().text();
		no.push(memberNo);
		const memberLevel = $(item).parent().parent().find("select").val();
		level.push(memberLevel);
	});
	location.href = "/chkedChangeLevel.do?no=" + no.join("/") + "&level=" + level.join("/");
});

$(document).on("click", ".deleteProd", function() {
	if (!confirm("제품을 정말 삭제하시겠습니까?")) {
		alert("취소를 누르셨습니다.")
	} else {
		const prodNo = $(this).parent().parent().children().eq(0).text();
		location.href = "/deleteProd.do?prodNo=" + prodNo;
	}
});
$(document).on("click", ".modification", function() {
	const prodNo = $(this).parent().parent().children().eq(0).text();
	location.href = "/modifyProdFrm.do?prodNo=" + prodNo;
});

$("button.delFile").on("click", function() {
	$(".delFile").hide();
	$(this).next().show();
	$("[name=status]").val("delete");
});
$(".orderstatus").on("click", function() {

	const orderNo = $(this).parent().parent().children().eq(1).text();
	const status = $(this).parent().prev().children().val();
	location.href = "/updateOrderStatus.do?orderNo=" + orderNo + "&status=" + status;

});
$(".chkOrders").on("click", function() {
	const chkBox = $(".chkBox:checked");
	if (chkBox.length == 0) {
		alert("선택된 배송상태가 없습니다.");
		return;
	}
	const orderNo = new Array();
	const status = new Array();
	chkBox.each(function(index, item) {
		const no = $(this).parent().next().text();
		orderNo.push(no);
		const ship = $(this).parent().parent().find("select").val();
		status.push(ship);
	});
	location.href = "/updateChkedOrderStatus.do?orderNo=" + orderNo.join("/") + "&status=" + status.join("/");
});

const category = $(".selectCateCode");
category.on("change", function() {
	const showProdCategory = $(".showProdCategory");
	$(".allProdList").hide();
	showProdCategory.empty();
	showProdCategory.show();
	const cateCode = category.val();
	if (cateCode == "5678") {
		$(".allProdList").show();
		showProdCategory.hide();
	} else {
		$.ajax({
			url: "getProdList.do",
			type: "get",
			data: { category: cateCode },
			dataType: "json",
			success: function(data) {
				for (let i = 0; i < data.length; i++) {
					const tr = $("<tr></tr>");
					const td1 = $("<td></td>");
					const td2 = $("<td></td>");
					const td3 = $("<td></td>");
					const td4 = $("<td></td>");
					const td5 = $("<td></td>");
					const td6 = $("<td></td>");
					const img = $("<img>");
					img.attr("src", "/upload/prodImg/" + data[i].productImg);
					img.attr("style", "width:100px; height: 100px");
					td6.append(img);
					const td8 = $("<td></td>");
					const td9 = $("<td></td>");
					const btn1 = $("<button></button>");

					btn1.addClass("btn btn-outline-dark modification");
					btn1.append("수정하기");
					td8.append(btn1);
					const btn2 = $("<button></button>");
					btn2.addClass("btn btn-outline-danger deleteProd");
					btn2.append("삭제");
					td9.append(btn2);
					td1.append(data[i].productNo);
					td2.append(data[i].cateCode);
					td3.append(data[i].productName);
					td4.append(data[i].productPrice);
					td5.append(data[i].productQty);

					tr.append(td1);
					tr.append(td2);
					tr.append(td3);
					tr.append(td4);
					tr.append(td5);
					tr.append(td6);

					tr.append(td8);
					tr.append(td9);
					showProdCategory.append(tr);
				}
			},
			error: function() {
				console.log("뭐가문제일까");
			}
		});

	}

})

$(".adminLogout").on("click", function() {
	if (confirm("로그아웃 하시겠습니까?")) {
		location.href = "/logout.do";
	} else {
		return;
	}
});


$("#productPrice").focusout(function() {
	const priceValue = $(this).val();
	const regExp = /^[0-9]+$/;
	if (regExp.test(priceValue)) {
		$("input[name=productQty]").focus();
	} else {
		alert("숫자를 입력해주세요");
	}
});

$("[name=productQty]").focusout(function() {
	const qtyValue = $(this).val();
	const regExp = /^[0-9]+$/;
	if (!regExp.test(qtyValue)) {
		alert("숫자를 입력해주세요");
	}
});





