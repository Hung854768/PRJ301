

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Account</title>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet" />
        <link href="css/all.min.css" rel="stylesheet" />
        <link href="css/templatemo-style.css" rel="stylesheet" />

    </head>
    <body>
        <jsp:include page="./header.jsp"/>

        <div class="container">


            <main>
                <header class="row tm-welcome-section">
                    <h2 class="col-12 text-center tm-section-title"> Register </h2>                   
                </header>

                <div class="tm-container-inner-2 tm-contact-section">
                    <div class="row">
                        <div class="col-md-6">
                            <h3 style="color: red">${requestScope.error}</h3>
                            <form action="register" method="get" > 
                                <div class="form-group"> 
                                    <input type="text" name="user" class="form-control" placeholder="Username" required="" /> 
                                </div> 
                                <div class="form-group"> 
                                    <input type="password" name="pass" class="form-control" placeholder="Password" required="" /> 
                                </div> 
                                <div class="form-group"> 
                                    <input type="text" name="fullname" class="form-control" placeholder="Fullname" required="" /> 
                                </div> 
                                <div class="form-group"> 
                                    <input type="text" name="phonenum" class="form-control" placeholder="Phone Number" required="" /> 
                                </div> 
                                <div class="form-group"> 
                                    <input type="text" name="email" class="form-control" placeholder="Email" required="" /> 
                                </div> 
                                <input type="submit" class="tm-btn tm-btn-primary tm-btn" value="Register"> 
                            </form>

                            <h3 > </h3>

                            <h3 > </h3>
                            <a href="login.jsp" class="tm-register">
                                <i>Already had account?</i>
                            </a>

                        </div>
                    </div>
                </div>


                

            </main>
            <div class="tm-container-inner tm-featured-image">
                <div class="row">
                    <div class="col-12">
                        <div class="placeholder-2">
                            <div class="parallax-window-2" data-parallax="scroll" data-image-src="img/simple-house-01.jpg"></div>		
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="./footer.jsp"/>


        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/parallax.min.js"></script>
        <script>
            $(document).ready(function () {
                var acc = document.getElementsByClassName("accordion");
                var i;

                for (i = 0; i < acc.length; i++) {
                    acc[i].addEventListener("click", function () {
                        this.classList.toggle("active");
                        var panel = this.nextElementSibling;
                        if (panel.style.maxHeight) {
                            panel.style.maxHeight = null;
                        } else {
                            panel.style.maxHeight = panel.scrollHeight + "px";
                        }
                    });
                }
            });
        </script>



    </body>
</html>
