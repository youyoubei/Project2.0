// JavaScript Document

	function checkname(){
	    var name = document.getElementById("name").value;
	  if(name==null|| name.length==0){
	    var wr = document.getElementById("wrongname").style.display = "block";
	    return false;
	    }
	    else{
	    var wr = document.getElementById("wrongname").style.display = "none";
	    return true;
	    }
	}
	function checkpwd(){
	    var pwd = document.getElementById("pwd").value;
	  if(pwd==null|| pwd.length==0){
	    var wr1 = document.getElementById("wrongpwd").style.display = "block";
	    return false;
	    }
	  else if(0<pwd.length&&pwd.length<8){
		var wr1 = document.getElementById("wrongpwd").style.display = "none";
		var wr2 = document.getElementById("length").style.display = "block";
		return false;
	  }
	    else{
	    var wr1 = document.getElementById("wrongpwd").style.display = "none";
	    var wr2 = document.getElementById("length").style.display = "none";
	    return true;
	    }
	}
	function checkpwd2(){
	    var pwd2 = document.getElementById("pwd2").value;
	    var pwd = document.getElementById("pwd").value;
	  if(pwd2==null|| pwd2.length==0){
	    var wr = document.getElementById("wrongpwd2").style.display = "block";
	    return false;
	    }
	    else if(pwd!=pwd2){
	    var wr = document.getElementById("wrongpwd2").style.display = "block";
	    return false;
	    }
	    else{
	    var wr = document.getElementById("wrongpwd2").style.display = "none";
	    return true;
	    }
	}
	function checkemail(){
	    var email = document.getElementById("email").value;
	    var reg = /\w+@\w+.\w+/g;
	    var tmp = email.match(reg);
	  if(email==null|| email.length==0){
	    var wr = document.getElementById("wrongemail").style.display = "block";
	    return false;
	    }
	    else if(tmp!=email){
	    	document.getElementById("wrongemail").style.display = "none";
	    	document.getElementById("wremail").style.display = "block";
	    	return false;
	    }
	    else{
	    var wr = document.getElementById("wrongemail").style.display = "none";
	    document.getElementById("wremail").style.display = "none";
	    return true;
	    }
	}

	function  check() {
		if(checkname()==false) return false;
		if(checkpwd()==false) return false;
		if(checkpwd2()==false) return false;
		if(checkemail()==false) return false;
			return true;
			
		}
	