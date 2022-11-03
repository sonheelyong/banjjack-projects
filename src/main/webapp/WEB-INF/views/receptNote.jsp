<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>받은 쪽지함</title>

        <link rel="stylesheet" href="/css/messageBox.css">
        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>

        <script>
           $( function() {
        		   $.ajax( {
        			   url  :  '/receptNote'  ,
        			   data :  {
        				   _id : $('#_id').val() ,
        				   content : $('#content').val(),
        				   send : $('#send').val() ,
        				   time : $('#time').val() ,
        		       },
        		       method   : "POST"
        		   } )
        		   .done(function( result, textStatus, xhr ) {
        			   console.log( result );
        			   var resultStr = JSON.stringify( result ); // JSOn -> string
        			   //alert(resultStr);
        			   var _id       = result._id;
        			   var content   = result.content;
        			   var send      = result.send;
        			   var html      = "<tr>";
        			   html         += '<td><input type ="checkbox" name = "chk_list"></td>';
        			   html         += '<td style="text-align: center;">' + _id + '</td>';
        			   html         += '<td style="text-align: center; padding-left:30px;">';
        			   html         += '<div class="cc">';
        			   html         += '<a href ="/readNote">'+ cont +'</a>';
        			   html         += '</div></td>';
        			   html         += '<td style="width:170px; text-align: center;">'+send+'</td>';
        			   html         += '<td style="width:200px; text-align: center;">'+time+'</td>';
        			   html         += '<td style="text-align: center;">' + _id + '</td>';
        			   html         += "</tr>";
        			   $('#noteList').html( html );
        		   })
        		   .fail(function(error, textStatus, errorThrown ) {
        			   conmsole.log ( error );
        			   alert('Error:' + error)
        		   });

        	   })


           });
        </script>
    </head>
    <body>
        
        
        <section>
            <div id="main_content">
                <div id="message_box">
                    <h3>
                       받은 쪽지함
                    </h3>
 
               
                    <div>
                           
      <table class="table_box" >
	<colgroup><col width="5%">
		<col width="10%">
		<col width="40%">
		<col width="25%">
		<col width="20%">
	</colgroup>
	
	<thead>
		<tr>
		    <th></th>	
		    <th>번호</th>
		    <th>내용</th>
			<th>보낸사람</th>
			<th>등록일</th>
				
		</tr>
	</thead>
			
	<tbody >	    
		    <div id="noteList">
		<tr>
		    <td><input type ="checkbox" name = "chk_list"></td>
			<td style="text-align: center;">11</td>
			<td style="text-align: center; padding-left:30px;">
		<div class="cc">
		<a href ="/ReadMessage">ㅇㄴ러나이러ㅏㄴ얼ㄴ이ㅓㄹ나이ㅓㄹ나이ㅓㄹㄴ이런이ㄴ이랑니;랑ㄴ;ㅣㅏ링;나리;ㄴ아리;ㅇ날;니아리;ㄴ아리;ㄴ알;ㅣㅇ나리;ㄴㅇ</a>
		</div>	
			</td>
			<td style="width:170px; text-align: center;">능린아ㅓ</td>
			<td style="width:200px; text-align: center;">2022-11-01</td>
		</tr >
		    </div>
	</tbody>
	
	<tbody>
		<tr >
		    <td><input type ="checkbox" name = "chk_list"></td>
			<td style="text-align: center;">22</td>
			<td style="text-align: center; padding-left:30px;">
		<div class="cc">
		<a href ="/ReadMessage">ㅇㄴ러나이러ㅏㄴ얼ㄴ이ㅓㄹ나이ㅓㄹ나이ㅓㄹㄴ이런이ㄴ이랑니;랑ㄴ;ㅣㅏ링;나리;ㄴ아리;ㅇ날;니아리;ㄴ아리;ㄴ알;ㅣㅇ나리;ㄴㅇ </a>
		</div>	
		 	</td>
			<td style="width:170px; text-align: center;">능린아d</td>
			<td style="width:200px; text-align: center;">2022-11-01</td>
		</tr>		
	</tbody>
</table>
<hr>
                        <!-- 쪽지함 이동 버튼들 -->
                        <ul class="buttons">
                            <li><button onclick="location.href='/SendMessage'">삭제</button></li>
                            <li><button onclick="location.href='/SendMessage'">보낸 쪽지함</button></li>                     
                            <li><button onclick="location.href='/WriteMessage'">쪽지 보내기</button></li>
                        </ul>
                    </div>
 
                </div>
            </div>
        </section>
 
    </body>
</html>