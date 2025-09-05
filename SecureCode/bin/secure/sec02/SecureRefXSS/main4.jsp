<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <style>
            .form {
                border: #323232 solid 1px;
                margin: auto;
                padding: 10px;
                width: 70vw;
                height: 100%;
            }

            .form__input {
                display: flex;
                flex-direction: column;
                gap: 1rem;
            }

            .form__input>div {
                display: flex;
                justify-content: space-between;
            }

            .form__button {
                margin-top: 10px;
                width: 100%;
            }

            .container {
                position: relative;
                overflow-x: auto;
                border: #323232 solid 1px;
                margin: 10px auto;
                padding: 10px;
                width: 70vw;
                height: 300px;
            }

            .container__header {
                position: absolute;
                top: 1rem;
                right: 1rem;
            }
        </style>
        
        <script>
        	function submitHandler() { // 서버측에 값을 전송하기 전에 XSS 공격에 취약한 
        		const keyword_input = document.querySelector("input[name='keyword']");
        		let keyword = keyword_input.value;

        	    keyword = keyword.replace(/&/g, "&amp;");
        	    keyword = keyword.replace(/</g, '&lt;');
        	    keyword = keyword.replace(/>/g, '&gt;');
        	    keyword = keyword.replace(/\(/g, '&#40;');
        	    keyword = keyword.replace(/\)/g, '&#41;');
        	    keyword = keyword.replace(/\//g, '&#47;');
        	    keyword = keyword.replace(/"/g, '&quot;');
        	    keyword = keyword.replace(/'/g, '&#x27;');
        	    

        	    keyword_input.value = keyword;
				return true;
        	    
        	}
        </script>
        
        <title>Insert title here</title>
    </head>

    <body>
        <h1>Reflected XSS 공격 </h1>

        <div class="form">
            <form action="reflected4.jsp" method="get" onsubmit="return submitHandler()">
                <div class="form__input">
                    <div>
                        <span> 검색 </span>
                        <input type="text" name="keyword" />
                    </div>
                </div>
                <input class="form__button" type="submit" value=" 검색 " />
            </form>
        </div>

        <div class="container">
	        <%
	        	request.setCharacterEncoding("UTF-8");
	        	// String keyword = request.getParameter("keyword"); // keyword 값이 없으면 null 반환
	        	// if (keyword == null) {
	        	// 	keyword = "";
	        	// }
	        %>
	        
        	<!-- jstl 라이브러리는 java코드가 아니기 때문에 자바스크립트 태그 사용 불가 -->
			<c:set var="keyword" value="${param.keyword}" />
			<c:if test="${empty keyword}">
				<c:set var="keyword" value=""/>
			</c:if>
			
			
				<div class="container__header"> 검색어 <c:out value="${keyword}"/> <!-- keyword 에 저장된 값이 출력 -->
                </div>
        </div>

    </body>

    </html>