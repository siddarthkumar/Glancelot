$(document).ready(function(){
	
})
function submit_form(){
		phone = $('input[name="phone"]').val();
		console.log(phone);
		sendOTP(phone);
		OtpPopup();
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
           alert(data);
        },
        error:function(){
          alert('error');
        }
     });
}

function moveOnMax(field,nextFieldID){
	  if(field.value.length >= field.maxLength){
	    document.getElementById(nextFieldID).focus();
	  }
	}

function OtpPopup(){
	Swal.fire({
		  title: '<br><br><strong>Enter OTP </strong>',
		  html:
			  '<div class="form-group pos_rel">'+
				'<ul class="code-alrt-inputs signup-code-list">'+
					'<li><input id="code1" name="number1" type="text" maxlength="1" onkeyup="moveOnMax(this,`code2`)" class="form-control input-md" required=""></li>'+
					'<li><input id="code2" name="number2" type="text" maxlength="1" onkeyup="moveOnMax(this,`code3`)" class="form-control input-md" required=""></li>'+
					'<li><input id="code3" name="number3" type="text" maxlength="1" onkeyup="moveOnMax(this,`code4`)" class="form-control input-md" required=""></li>'+
					'<li><input id="code4" name="number4" type="text" maxlength="1" onkeyup="moveOnMax(this,`code5`)"class="form-control input-md" required=""></li>'+
					'<li><input id="code5" name="number5" type="text" maxlength="1" class="form-control input-md" required=""></li><br><br>'+
					'<li></li>'+
				'</ul>'+
				'<a class="chck-btn hover-btn code-btn145  varifyOTP" href="#">Verify OTP</a><br><br>'+
				'<small class="popUp-text">OTP can Take upto 1 Minute to Deliver.<br> Did not Get OTP Yet?<a href="#" class="resendOtp">Resend OTP</a></small>	'+
			'</div>',
		  showCloseButton: true,
		  showConfirmButton:false,
		  allowOutsideClick: false,
		  focusConfirm: false,
		})
	$(".varifyOTP").click(function(){
		var otp1 = $("#code1").val();
		var otp2 = $("#code2").val();
		var otp3 = $("#code3").val();
		var otp4 = $("#code4").val();
		var otp5 = $("#code5").val();
		var entered_otp = otp1+otp2+otp3+otp4+otp5;
		alert(entered_otp );
		verifyOTP(entered_otp)
	})
}

function verifyOTP(entered_otp){
	$.ajax({
        url:'/verifyotp',
        data:{
        	enteredOtp:`${entered_otp}`
    	},
        type:'get',
        cache:false,
        success:function(data){
           if(data==="verified"){
        	   registerUser();
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


function registerUser(){
	 var datastring = $("#signUpForm").serialize();
	 
	$.ajax({
	  url:'/registered',
	  data:  datastring	,
	  type:'post',
	  cache:false,
	  success:function(data){
		Swal.fire({
			  title: '<br><br><strong>Successfully Registered</strong>',
			  icon:'success',
			  html:'<center>You Are Successfully Registered.<br>For login click <a href="signIn.jsp">Login</a></center>'+
				  '<a href="/"><button>Home</button></a>',
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
			  text: 'Something went wrong!<br>You are not Successfully Added.',
			  footer: '<a href="#">Why do I have this issue?Report Problem</a>'
			})
	  }
	});
}