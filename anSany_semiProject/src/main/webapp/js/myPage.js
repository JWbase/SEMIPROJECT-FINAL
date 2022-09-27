function myPageQnADelete(qnaNo,memberId){
	if(confirm("문의내역을 삭제하시겠습니까?")){
		location.href="/myPageQnADelete.do?qnaNo="+qnaNo+"&&memberId="+memberId;
	}
}
function addComma(value){
                value = value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
                return value;
        };