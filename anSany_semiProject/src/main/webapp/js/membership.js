$(".membership-tabs").children().eq(0).on("click",function(){
    $(this).children().addClass("membership-toggleClass");
    $(".membership-tabs").children().eq(1).children().removeClass();
    $(".prem-contentwrap").hide();
    $(".membership-contentArea").show();
    $(".membership-TableHead").show();
    
});

$(".membership-tabs").children().eq(1).on("click",function(){
    $(this).children().addClass("membership-toggleClass");
    $(".membership-tabs").children().eq(0).children().removeClass();
    $(".membership-contentArea").hide();
    $(".membership-TableHead").hide();
    $(".prem-contentwrap").show();
});
$(".membership-tabs").children().eq(0).click();