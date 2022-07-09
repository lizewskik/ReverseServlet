<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CGM Exercise</title>
<style>
	body{
		background-color: whitesmoke;
	}
	
	.display{
		display: flex;
		flex-direction: row;
		padding: 1%;
		border: 2px solid black;
		border-radius: 10px;
	}
	
	#result{
		font-weight: bold;
		font-size: 120%;
	}
	
	#scd{
		font-size: 150%;
	}
</style>
</head>
<body>
	<h1>CGM Exercise</h1>
	<form class="display" id="form">
		Enter text: <input type="text" id="word" title="enter only letters and digits"><input type="submit" value="Reverse">
	</form>
	<br>
	<div class="display" id="result">Try this webapp</div>
	<br>
	<a  id="scd" href="/CGMExercise/scdver">Try second version!</a>
<script>
	const form = document.getElementById("form");
	const word = document.getElementById("word");
	const result = document.getElementById("result");
	
	const regex = /^[A-Za-z0-9]*$/;
	
	form.onclick = async function (event){
		event.preventDefault(); // prevent from submit
		if(await regex.test(word.value)){
			const response = await fetch("./reverse?word="+word.value);
			const output = await response.text();
			result.innerText = output;
		}
		else{
			result.innerText = "Text has to contain only letters and digits"
				+"and it can't be empty"
		}
	}
</script>
</body>
</html>