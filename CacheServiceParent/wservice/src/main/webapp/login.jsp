<head>
		<title>Cache Service CMS</title>
		<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular.min.js"></script>
		<script src="js/main.js"></script>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body class="background">
		<div ng-app="" ng-init="username='admin'" id="login" >
			<form action="pages/index.jsp?action=createService" method="post" class="shadow border bg radius">
				<h2>Welcome to cache service</h2>
				<div class="row">
					<label>Username: </label>
					<input type="text" name="username" ng-model="username"></input>
				</div>
				<div class="row">
					<label>Password: </label>
					<input type="password" name="password"></input>
				</div>
				<div class="row">
					<input type="submit" value="Login" id="submit" class="shadow border"></input>
				</div>
			</form>
		</div>
	</body>