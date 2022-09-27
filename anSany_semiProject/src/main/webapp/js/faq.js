$(".faq-tab>ul>li>a").on("click",function(){
    $(".faq-tab>ul>li>a").css("color","black");
    $(".faq-tab>ul>li").css("background-color","white");
    $(this).css("color","white");
    $(this).parent().css("background-color","#5865f5");
});

$(".faq-questions-head>a").on("click",function(){
    $(this).parent().next().slideToggle(300);
});

$(".faqqna-tab>ul").children().eq(0).on("click",function(){
    $(".faq-content").show();
    $(".questions-div").show();
    $(".faq-answer").hide();
    $(".faq-tab>ul").children().eq(0).children().click();
    for(let i = 7; i < 13; i++){
        $(".questions-div").eq(i).hide();
    }
    $(".addfaq-Btn").children().show();
    $(".qna-content").hide();

    $(".faqqna-tab>ul").children().eq(0).children().addClass("faqqna-addColor");
    $(".faqqna-tab>ul").children().eq(1).children().removeClass("faqqna-addColor");
});

$(".faqqna-tab>ul").children().eq(1).on("click",function(){
    $(".faq-content").hide();
    $(".questions-div").hide();
    $(".addfaq-Btn").children().hide();
    $(".qna-content").show();

    $(".faqqna-tab>ul").children().eq(1).children().addClass("faqqna-addColor");
    $(".faqqna-tab>ul").children().eq(0).children().removeClass("faqqna-addColor");
    
});

$(".addfaq-Btn").children().on("click",function(){
    for(let i = 7; i < 13; i++){
        $(".questions-div").eq(i).show();
    }
    $(this).hide();
});

for(let i = 7; i < 13; i++){
    $(".questions-div").eq(i).hide();
}
$(".material-icons").parent().on("click",function(){
    $(this).children().eq(2).toggleClass("toggle-arrow");
});


const questionstab = $(".faq-tab>ul>li");
questionstab.on("click",function(){
    const tabindex = questionstab.index(this);
    $(".faq-questions-head").find(".material-icons").removeClass("toggle-arrow");
    $(".qna-content").hide();
    if(tabindex == 0){
        $(".addfaq-Btn").children().show();
        $(".questions-div").show();
        $(".faq-answer").hide();
        for(let i = 7; i < 13; i++){
            $(".questions-div").eq(i).hide();
        }
    } 
    if(tabindex >= 1){
        $(".questions-div").hide();
        $(".addfaq-Btn").children().hide();
        $(".faq-answer").hide();
        if(tabindex == 1){
            for(let i =0; i < 5; i++){
                $(".questions-div").eq(i).show();
            }
        } else if(tabindex == 2){
            $(".questions-div").eq(5).show();
            $(".questions-div").eq(6).show();
        } else if(tabindex == 3){
            $(".questions-div").eq(7).show();
            $(".questions-div").eq(8).show();
        } else if(tabindex == 4){
            $(".questions-div").eq(9).show();
            $(".questions-div").eq(10).show();
        } else if(tabindex == 5){
            $(".questions-div").eq(11).show();
            $(".questions-div").eq(12).show();
        }
    }
});
$(".faqqna-tab>ul>li").eq(0).click();
