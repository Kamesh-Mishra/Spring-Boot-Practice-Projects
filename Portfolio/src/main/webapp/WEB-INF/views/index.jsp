<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>PORTFOLIO | Kamesh Mishra</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header">
						<div class="logo">
							<span class="icon fa-gem"></span>
						</div>
						<div class="content">
							<div class="inner">
								<h1>Kamesh Mishra</h1>
								<p>Learner | Engineer | Geek<br /></p>
							</div>
						</div>
						<nav>
							<ul>
								<li><a href="#intro">Intro</a></li>
								<li><a href="#about">Projects</a></li>
								<li><a href="#contact">Contact</a></li>
							</ul>
						</nav>
					</header>

				<!-- Main -->
					<div id="main">

						<!-- Intro -->
							<article id="intro">
								<h2 class="major">Intro</h2>
								<span class="image main"><img src="images/pic01.jpg" alt="" /></span>
								<p>I ❤️ Technology, <br> Collaborative and Passionate Computer Science Engineer.</p>
								<p>
									Software Engineering has always fascinated me right from my academic years.
									What has always intrigued me is how Code can be converted into valuable Softwares with a magic sauce of algorithms.<br>
									Key Skills: Java, SQL, Spring, Spring Boot, RestAPI, MicroServices, Backend Development.
								</p>
								<p><i><center>" Trust the Wait, Embrace the Uncertainty. "</center></i></p>
								<p>
									My Portfolio : <a href="https://Kamesh-Mishra.github.io/">Portfolio</a><br>
									My Github Profile: <a href="https://github.com/Kamesh-Mishra">GitHub</a><br>
									My LinkedIN: <a href="https://www.linkedin.com/in/kameshmishra/">LinkedIn</a><br>
									My Resume: <a href="https://drive.google.com/file/d/1rNNDaCXegIX_nvo5YpIwGyj8O2XD8UHN/view?usp=sharing">Resume</a><br>
								</p>
							</article>

						<!-- Projects Section -->
						<article id="projects">
							<h2 class="major">Projects</h2>
							<jsp:include page="projects.jsp"/>
						</article>

						<!-- Contact Section -->
						<article id="contact">
							<h2 class="major">Contact Me</h2>
							<p><center>I am available on almost every social media. You can message me, I will reply within 24 hours.</center></p>
							<jsp:include page="contact.jsp"/>
						</article>

					</div>

				<!-- Footer -->
					<footer id="footer">
						<p class="copyright"><h4>© 2025 Made with ❤️ by Kamesh Mishra</h4></p>
					</footer>
			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>