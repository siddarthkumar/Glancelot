<!DOCTYPE html>
<html lang="en">


<head>
    <!-- Required meta tags always come first -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Login</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
    <link href="https://mdbootstrap.com/previews/docs/latest/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://mdbootstrap.com/previews/docs/latest/css/mdb.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="home.css">


    <style type="text/css">
        
    html,
    body,
    header,
    .view {
      height: 100%;
    }

    @media (min-width: 851px) and (max-width: 1440px) {
      html,
      body,
      header,
      .view {
        height: 850px;
      }
    }

    @media (min-width: 800px) and (max-width: 850px) {
      html,
      body,
      header,
      .view {
        height: 1000px;
      }
    }

    @media (min-width: 451px) and (max-width: 740px) {
      html,
      body,
      header,
      .view {
        height: 1200px;
      }
    }

    @media (max-width: 450px) {
      html,
      body,
      header,
      .view {
        height: 1400px;
      }
    }

    .intro-2 {
      background: url("images/login.png")no-repeat center center;
      background-size: contain;
    }

    .top-nav-collapse {
      background-color: #3f51b5 !important;
    }

    .navbar:not(.top-nav-collapse) {
      background: transparent !important;
    }

    @media (max-width: 768px) {
      .navbar:not(.top-nav-collapse) {
        background: #3f51b5 !important;
      }
    }
    @media (min-width: 800px) and (max-width: 850px) {
        .navbar:not(.top-nav-collapse) {
            background: #3f51b5!important;
        }
    }

    .rgba-gradient {
      background: -webkit-linear-gradient( rgba(0,0,0, 0.8), rgba(200, 200, 200, 0.5), rgba(200, 200, 200, 0.5),rgba(0,0,0, 0.9) );
      /*background: -webkit-gradient(linear, 98deg, from(rgba(22, 91, 231, 0.5)), to(rgba(255, 32, 32, 0.5)));*/
      /*background: linear-gradient(to 98deg, rgba(0, 0, 0, 0.5), rgba(255, 32, 32, 0.5) 100%);*/
    }

    .card {
      background-color: rgba(0, 0, 0, 0.8);
    }

    h6 {
      line-height: 1.7;
    }
    .hide{
      display: none;
    }

    ul.code-alrt-inputs input {
      width: 40px;
      border: 1px solid #efefef;
      text-align: center;
      padding: 0;
      font-size: 14px;
      font-weight: 500;
      font-family: 'Roboto', sans-serif;
    }

  ul.code-alrt-inputs input:focus {
    box-shadow: none;
    border: 1px solid var(--theme-color);
  }

  ul.code-alrt-inputs.signup-code-list{
    list-style: none;
  }

  ul.code-alrt-inputs.signup-code-list li{
    display: inline-block;
  }	
    </style>

</head>
<body> 
    
    <!--Intro Section-->
    <section class="view intro-2 text-white">
        <div class="mask rgba-gradient">
          <div class="container mt-3 d-flex justify-content-center align-items-center">

            <!--Grid row-->
            <div class="row  pt-5 mt-3">

              <!--Grid column-->
              <div class="col-md-12">

                <div class="card">
                  <div class="card-body">

                    <h2 class="font-weight-bold my-4 text-center mb-5 mt-4 font-weight-bold">
                      <strong style="font-family: ui-sans-serif"><u><i>Sign In</i></u></strong>
                    </h2>
                    <hr>

                    <!--Grid row-->
                    <div class="row mt-5">

                      <!--Grid column-->
                      <div class="col-md-6 ml-lg-5 ml-md-3">

                        <!--Grid row-->
                        <div class="row pb-4">
                          <div class="col-2 col-lg-1">
                            <i class="fas fa-university themeColor fa-lg"></i>
                          </div>
                          <div class="col-10">
                            <h4 class="font-weight-bold mb-4">
                              <strong>Safety</strong>
                            </h4>
                            <p class="">All your calls are safe while you are using our servers. World class Security with end to end encryption </p>
                          </div>
                        </div>
                        <!--Grid row-->

                        <!--Grid row-->
                        <div class="row pb-4">
                          <div class="col-2 col-lg-1">
                            <i class="fas fa-desktop themeColor fa-lg"></i>
                          </div>
                          <div class="col-10">
                            <h4 class="font-weight-bold mb-4">
                              <strong>Techology Advantage</strong>
                            </h4>
                            <p class="">With the Technology that is being used you will never have to face lagging again , unless your camera is broken.
                            Enjoy High Quality unlimited video calls without any latency </p>
                          </div>
                        </div>
                        <!--Grid row-->

                        <!--Grid row-->
                        <div class="row pb-4">
                          <div class="col-2 col-lg-1">
                            <i class="fas fa-money-bill-alt themeColor fa-lg"></i>
                          </div>
                          <div class="col-10">
                            <h4 class="font-weight-bold mb-4">
                              <strong>Thinking about  Cost? </strong>
                            </h4>
                            <p class="">Unlimited Video Calls with no under the hood charges.Chat with anyone ,anytime ,anywhere !</p>
                          </div>
                        </div>
                        <!--Grid row-->

                      </div>
                      <!--Grid column-->

                      <!--Grid column-->
                      <div class="col-md-5">

                        <!--Grid row-->
                        <!-- <div class="row pb-4 d-flex justify-content-center mb-4">

                          <h4 class="mt-3 mr-4">
                            <strong>Login with</strong>
                          </h4>

                          <div class="inline-ul text-center d-flex justify-content-center">
                            <a class="p-2 m-2 fa-lg tw-ic">
                              <i class="fab fa-twitter fa-lg indigo-text"></i>
                            </a>
                            <a class="p-2 m-2 fa-lg li-ic">
                              <i class="fab fa-linkedin-in fa-lg indigo-text"> </i>
                            </a>
                            <a class="p-2 m-2 fa-lg ins-ic">
                              <i class="fab fa-instagram fa-lg indigo-text"> </i>
                            </a>
                          </div>

                          <h4 class="mt-3 ml-4">
                            <strong>or:</strong>
                          </h4>

                        </div> -->
                        <!--/Grid row-->

                        <!--Body-->
                        <form action="dostuff">
                        <div class="md-form">
                          <i class="fas fa-envelope themeColor prefix"></i>
                          <input type="text" name = "email" id="orangeForm-email" class="form-control">
                          <label for="orangeForm-email">Your email</label>
                        </div>

                        <div class="md-form">
                          <i class="fas fa-lock themeColor prefix"></i>
                          <input type="password" name ="password" id="orangeForm-pass" class="form-control">
                          <label for="orangeForm-pass">Your password</label>
                          <div style="text-align: right;">
                            <span class="text-center"    onclick="forgetPassword()"><small><a>Forget Password?</a></small></span>
                          </div>
                        </div>

                        <div class="text-center">
                          <button type ="submit" class="btn themeBackground btn-rounded mt-5">Sign In</button>
                          <button type="button" class="btn themeBackground btn-rounded mt-5" onclick="loginWithOtp()">Continue with OTP</button>
                        </div>
                           </form>

                      </div>
                      <!--Grid column-->

                    </div>
                    <!--Grid row-->

                  </div>
                </div>

              </div>
              <!--Grid column-->

            </div>
            <!--Grid row-->

          </div>
        </div>
    </section>
    <!--Intro Section-->
  <!--Main Navigation-->


    <!-- SCRIPTS -->
    <script type="text/javascript" src="https://mdbootstrap.com/previews/docs/latest/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="https://mdbootstrap.com/previews/docs/latest/js/popper.min.js"></script>
    <script type="text/javascript" src="https://mdbootstrap.com/previews/docs/latest/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://mdbootstrap.com/previews/docs/latest/js/mdb.min.js"></script>
    <script type="text/javascript" src="js/sweetalert2.1.2.min.js"></script>
    <script type="text/javascript" src="js/login.js"></script>

    <script>
    </script>
</body>
</html>