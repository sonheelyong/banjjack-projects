<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>����</title>
    <link rel="stylesheet" href="/css/message.css?sdfsd">
</head>
<body>
    <section>
        <div id="main_content">
            <div id="message_box">
                <h3 id="write_title">���� ����</h3>
 
                
                <ul class="top_buttons">
                    <li><a href="/RecepMessage">���� ������</a></li>
                    <li><a href="/SendMessage">���� ������</a></li>
                </ul>               
               <form action="" method="post" name="message_form">
                        <div id="write_msg">
                            <ul>
                                <li>
                                    <span class="col1">���� ��� : </span>
                                    <span class="col2">����������̵�</span>
                                </li>
                                
                                <li id="textarea">
                                    <span class="col1">���� : </span>
                                    <span class="col2"><textarea name="content"></textarea></span>
                                </li>                                
                            </ul>
                            <input type="submit" value="�����ϱ�">
                        </div>
                </form>
            </div>
 
        </div>
 
    </section>
 
    
</body>
</html>