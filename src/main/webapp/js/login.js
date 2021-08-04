function loginWithOtp(){
	Swal.fire({
	  title: 'Login With OTP<br><br>',
	  html:'<form  action="" method="" class="forgotPasswordForm" id="forgotPasswordForm">'+
			  '<div class="form-group" id="phoneNoInput">'+
			   ' <label for="exampleInputEmail1"><small>Registered Phone</small></label>'+
			   ' <input type="number" name="registerPhone" class="form-control" placeholder="Phone" >'+
			 ' </div>'+
			 '<div class="row form-group pos_rel hide" id="enterOtp">'+
				'<div class="col-md-8">'+
					 '<ul class="code-alrt-inputs signup-code-list">'+
						'<li><input id="code1" name="number1" type="text" maxlength="1" onkeyup="moveOnMax(this,`code2`)" class="form-control input-md" required=""></li>'+
						'<li><input id="code2" name="number2" type="text" maxlength="1" onkeyup="moveOnMax(this,`code3`)" class="form-control input-md" required=""></li>'+
						'<li><input id="code3" name="number3" type="text" maxlength="1" onkeyup="moveOnMax(this,`code4`)" class="form-control input-md" required=""></li>'+
						'<li><input id="code4" name="number4" type="text" maxlength="1" onkeyup="moveOnMax(this,`code5`)" class="form-control input-md" required=""></li>'+
						'<li><input id="code5" name="number5" type="text" maxlength="1" class="form-control input-md" required=""></li>'+
					'</ul>'+
			 	'</div>'+
				'<div class="col-md ml-md-2">'+
					'<a class="chck-btn hover-btn code-btn145  varifyOTP" href="#">Verify OTP</a><br><br>'+
				'</div>'+
				'<br><br><small class="ml-3">OTP can Take upto 1 Minute to Deliver.<br> Did not Get OTP Yet?<a href="#" onClick="resendOTP()" class="">Resend OTP</a></small>	'+
				'<br><br><small class="ml-3">Entered Wrong Number?<a href="#" onClick="editPhone()" class="">Edit Phone</a></small>	'+
			'</div>'+
			  '<div class="form-group mt-4" id="sendOtpButton" style="text-align: center;"><button type="button" onclick="method1()" class="btn btn-primary">Send OTP</button></div>'+
			'</form>',
	  showCloseButton: true,
	  showCancelButton: false,
	  showConfirmButton: false,
	  allowOutsideClick: false
	})
	
	$(".varifyOTP").click(function(){
		verifyEnteredOtp();
	})
}

function getForgotPasswordFormData(){
	 updatePassword($("#forgotPasswordForm").serialize());
}

function updatePassword(datastring){
	$.ajax({
        url:'/groceriesHub.com/pages/forgotPassword',
        data:datastring,
        type:'post',
        cache:false,
        success:function(data){           
    		Swal.fire({
  			  title: '<br><br><strong>Successfully Updated</strong>',
  			  icon:'success',
  			  html:'<center>Your Password Is successfully Updated.<br>For login click <a href="/groceriesHub.com/pages/signIn.jsp">Login</a></center>' ,
  			  showCloseButton: false,
  			  showConfirmButton:false,
  			  allowOutsideClick: false,
  			  focusConfirm: false,
    		}) 
        },
        error:function(){
        	Swal.fire({
  			  icon: 'error',
  			  title: 'Oops...',
  			  text: 'Something went wrong!<br>Unable to Reset Your Password. Try again Later',
  			  footer: '<a href="#">Why do I have this issue?Report Problem</a>'
  			})
        }
     });
}


var generated_otp;
var phone;
function method1(){
	
	phone = $('input[name="registerPhone"]').val();
	sendOTP(phone);

// isko remove jb checkPhoneRegister Ho jaye
	   $('input[name="registerPhone"]').attr("readonly","");
 	   $("#sendOtpButton").addClass('hide');
   	   $("#enterOtp").removeClass("hide");
   	   // yaha tk remove
}

function sendOTP(phone){
	$.ajax({
        url:'/sendsms',
        data:{
        	mobile:`${phone}`
    	},
        type:'get',
        cache:false,
        success:function(data){
          console.log(data);
        },
        error:function(){
         console.log('error');
        }
     });
}

function verifyEnteredOtp(){
	var otp1 = $("#code1").val();
	var otp2 = $("#code2").val();
	var otp3 = $("#code3").val();
	var otp4 = $("#code4").val();
	var otp5 = $("#code5").val();
	var entered_otp = otp1+otp2+otp3+otp4+otp5;
	console.log(entered_otp );
	
	$.ajax({
        url:'/verifyotp',
        data:{
        	enteredOtp:`${entered_otp}`
    	},
        type:'get',
        cache:false,
        success:function(data){
           if(data==="verified"){
        	   
           }
           else{
        	   alert("Wrong OTP")
           }
        },
        error:function(){
          alert('error');
        }
     });

}

function loginWithOtpSuccess(){
	location.href='/loginwithotp?phone='+phone;
}

function editPhone(){
	 $('input[name="registerPhone"]').removeAttr("readonly");
 	 $("#sendOtpButton").removeClass('hide');
	 $("#enterOtp").addClass("hide");
}

function moveOnMax(field,nextFieldID){
//	  if(field.value.length >= field.maxLength){
//	    document.getElementById(nextFieldID).focus();
//	  }
	}

function showPassword() {
	var x = $(".myPassword");
	var y = x.attr("type");
	if (y === "password") {
		x.attr("type","text");
	} else {
		x.attr("type","password");
	}
}