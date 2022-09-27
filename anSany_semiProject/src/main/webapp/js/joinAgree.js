$("#flexSwitchCheckDefault").on("click",function(){
    const chk = $(this).is(":checked");
    if(chk){
        $(".inp_check").prop('checked',true);
    } else{
        $(".inp_check").prop('checked',false);
    }
});

const btnView = $(".btn_view");
btnView.on("click",function(event){
    event.preventDefault();
    $(".modal-wrap").css("display","flex");
    const index = btnView.index(this);
    $(".allViewAgree").hide();
    $(".allViewAgree").eq(index).show();
});
$(".material-symbols-outlined").on("click",function(){
    $(".modal-wrap").css("display","none");
});

const agreeOneBtn = $(".chkBtn")
agreeOneBtn.on("click",function(){
    const index = agreeOneBtn.index(this);
    $(".inp_check").eq(index).prop('checked',true);
    $(".modal-wrap").css("display","none");
});

let essential = [];
$("#agreenextBtn").on("click",function(){
	essential[0] = $("#chk00").is(":checked");
	essential[1] = $("#chk01").is(":checked");
	essential[2] = $("#chk02").is(":checked");
	essential[3] = $("#chk03").is(":checked");
	
	if(essential[0] && essential[1] && essential[2] && essential[3] == true){
		location.href="/joinFrm.do";
	}else{
		alert("약관에 동의하세요");
	}
});
