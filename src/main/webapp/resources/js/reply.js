const replyService = (function (){

    //댓글추가
    const addReply = async function (replyObj , callback) {

        const res = await axios.post("/replies/" , replyObj)

        callback()
    }
    //댓글을 가져오는
    const getList = async function ({bno,page,size} , callback) {

        const parameter = {page:page||1 , size:size||10 }

        const res = await axios.get(`/replies/list/${bno}`,{params:parameter})

        callback(res.data)
    }

    return{addReply , getList}

})()

const qsAddEvent = function (selector , type , callbak){
    const target = document.querySelector(selector)

    target.addEventListener(type , callbak , false)
}


