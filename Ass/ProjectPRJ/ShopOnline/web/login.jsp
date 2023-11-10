

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Login</title>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet" />
        <link href="css/all.min.css" rel="stylesheet" />
        <link href="css/templatemo-style.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <!-- Top box -->
            <jsp:include page="./header.jsp"/>

            <main>
                <h2 class=" text-center " style="margin: 20px;"> Login your account</h2>                   
                <h3 style="color: red; text-align: center">${requestScope.ms}</h3>
                <div >
                    <div class="row">
                        <div class="col-md-4"></div>

                        <div class="col-md-4" style="padding-left: 40px;">
                            <form action="login" method="POST" class="tm-contact-form">
                                <h3 style="color: red">${requestScope.error}</h3>

                                <div class="form-group">
                                    <input type="text" name="name"  class="form-control" placeholder="Username" required="" />
                                </div>

                                <div class="form-group">
                                    <input type="password" name="pass"  class="form-control" placeholder="Password" required="" />
                                </div>                              

                                <h3></h3>
                                <div class="form-group tm-d-flex">

                                    <input type="submit" class="tm-btn tm-btn-primary tm-btn" value="Login"/>


                                </div>


                            </form>


                            <h3></h3>
                            <a href="register.jsp" class="tm-register">
                                <i>Haven't have account yet?</i>
                            </a>

                        </div>




                        </main>



                    </div>
                    <jsp:include page="./footer.jsp"/>
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
