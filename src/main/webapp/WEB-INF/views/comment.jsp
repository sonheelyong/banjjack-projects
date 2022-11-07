<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <title>on progress</title>
        <meta charset="utf-8">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined"
        rel="stylesheet">
            
        <style>
            div.commentListBox { width:600px; height: auto ; }
            div.commentBigBox { display: flex; padding-bottom: 20px; display: inline-block;}
            div.commentIcon { float:left; width:50px; position : relative ;
                             margin-top: auto ; margin-bottom: auto; margin-left:1px ;
                             text-align: center;}
            div.commentBox { float:right; width:530px; }
            div.commentText { width:600px; display: flex ; flex-direction: column;}
            span.commentEditBtn { float:right; margin-right:2px; }
            span.commentDelBtn { float:right; margin-right:2px; }
            span.comWriter > input { width:100px ; border:none; font-weight: 600; font-size: large;}
            div.commentText { width:540px; margin-top:2px;}
            div.commentInputBox{width:600px; margin-top:30px;}
            textarea { width:600px; resize:none; }
            div.regBtn { float:right;}
        </style>
        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
    <script>
        window.onload = function (){
            fnCommentList();
        }
        function fnCommentList() {
            $.ajax({
                url: "/comment/commentList?content_id=1",
                type: "get",
                error:function(xhr){
                    console.log("error html = " + xhr.statusText);

                },
                success: function (data) {
                    console.log(data);


                    let str = "";
                    $.each(data, function (index, element) {
                        console.log(element);
                        console.log(element.name);
                        console.log(element.content);

                        str += "<div class=\"commentIcon\">"
                               + "<span class=\"material-icons-outlined\">"
                               + "android"
                    +"</span>"
                        +"</div>"
                        +"<div class=\"commentBox\">"
                    +"<span class=\"comWriter\">"
                            +"<input type=\"text\" name=\"comWriter\" value=\'"+ element.name + "\'>"
                    +"</span>"
                            +"<span class=\"commentDelBtn\">"
                        +"<button> 삭제 </button>"
                    +"</span>"
                            +"<span class=\"commentEditBtn\">"
                        +"<button> 수정 </button>"
                    +"</span>"
                            +"<span class=\"commentdate\">"
                        +"<input type=\"text\" name=\"commentdate\">"
                    +"</span>"
                            +"<div class=\"commentText\">"
                                +element.content
                                +"<br>"
                            +"</div>"
                        +"</div>"

                        <%--str +=--%>
                        <%--    + '<div class="commentBox">' +'' +'</div>'--%>
                        <%--    + '<div class="commentIcon">' +'' +'</div>'--%>
                        <%--    + '<span class="comWirter">' + element.username + '</span>'--%>
                        <%--    + '<span class="commentdate">' + element.time + '</span>'--%>
                        <%--    + '<div class="commentText">' + element.content + '</div>';--%>

                        <%--&lt;%&ndash;if(element.username=="${}"){&ndash;%&gt;--%>
                        <%--&lt;%&ndash;    str=str+   '<button name="commentEdit" type="button" class="commentEdit" >수정</button>'&ndash;%&gt;--%>
                        <%--&lt;%&ndash;        +  '<button name="commentDel" type="button" class="commentDel" >삭제</button>';&ndash;%&gt;--%>
                        <%--&lt;%&ndash;}&ndash;%&gt;--%>
                        <%--str = str + '</div>'--%>
                        <%--    + '</div>';--%>
                    })
                    document.getElementById('commentBigBox').innerHTML += str;
                }
            });
        }
        $.ajax({
            url:"/comment/wirtecomment",
            type:"get",
            success: function (data) {




        }



    </script>

    </head>
    <body>
        <div class="commentCount"> 댓글 <span id = "count">0</span></div>
    <!--댓글 리스트 -->
        <div class="commentListBox" id="commentListBox">
            <div class="commentBigBox" id="commentBigBox">
                <div class="commentIcon">
                    <span class="material-icons-outlined">
                        android
                    </span>
                </div>
                <div class="commentBox">
                    <span class="comWriter">
                            <input type="text" id="comWriter" name="comWriter" >
                    </span>
                        <!-- 버튼은 등록자 본인만 -->
                    <span class="commentDelBtn">
                        <button id="commentDel"> 삭제 </button>
                    </span>
                    <span class="commentEditBtn">
                        <button id="commentEdit"> 수정 </button>
                    </span>
                    <span class="commentdate">
                        <input type="text" id="commentdate" name="commentdate">
                    </span>
                    <div class="commentText">
                        용: 샘플입니다.내용: 샘플입니다.내용: 샘플입니다.내용: 샘플입니다.내용: 샘플입니다.내용: 샘
                        <br>
                    </div>
                </div>


            </div>
        </div>



        <!--댓글 입력부 -->

        <div class="commentInputBox">
            <form action="/comment/commentWrite" id="comInputForm" method="POST" name="comInputForm">
                <textarea class="commentInput" id="comInput" cols="80" rows="3" name="comInput" >
                </textarea>
                <div class="countNum">
                    ( 0/ 300)
                </div>
                <div class="regBtn">
                    <button id="commentWrite"> 등록</button>
                </div>
            </form>
        </div>


    <script>

        $('.commentInput').on('keyup', function() {
            $('.countNum').html("("+$(this).val().length+" / 300)");

            if($(this).val().length > 300) {
                $(this).val($(this).val().substring(0, 300));
                $('.countNum').html("(300 / 300)");
                alert("300자가 초과되었습니다")
                }
            });

    </script>

    </body>

</html>