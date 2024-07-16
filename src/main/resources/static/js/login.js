function setCookie(name, value, days) {
	let expires = "";
	if (days) {
		const date = new Date();
		date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
		expires = "; expires=" + date.toUTCString();
	}
	document.cookie = name + "=" + (value || "") + expires + "; path=/";
}

function login() {
	const email = document.getElementById("email").value;
	const password = document.getElementById("password").value;

	fetch('/auth/login', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({ email: email, password: password })
	})
		.then(response => response.json())
		.then(data => {
			if (data.token) {
				localStorage.setItem('token', data.token);
				setCookie('auth_token', data.token, 7);
				window.location.href = '/';
			} else {
				alert('Login failed');
			}
		})
		.catch(error => console.error('Error:', error));
}
