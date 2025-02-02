<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="styles.css" rel="stylesheet">
    <style type="text/css">
    body {
    background: url('data:image/jpeg;base64,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') no-repeat center center fixed;
    background-size: cover;
    font-family: 'Arial', sans-serif;
}

.card {
    border: none;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    background-color: rgba(255, 255, 255, 0.9);
}

.card-title {
    color: #333;
    font-size: 24px;
    font-weight: bold;
}

.form-control {
    border-radius: 5px;
    border: 1px solid #ced4da;
}

.btn-primary {
    background-color: #007bff;
    border-color: #007bff;
    border-radius: 5px;
}

.btn-primary:hover {
    background-color: #0056b3;
    border-color: #0056b3;
}
    </style>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card mt-5">
                    <div class="card-body">
                        <h3 class="card-title text-center mb-4">Registration Form</h3>
                        <form action="register" method="post">
                            <div class="form-group">
                                <label for="name">Name</label>
                                <input type="text" class="form-control" name="name" placeholder="Enter your name">
                            </div>
                            <div class="form-group">
                                <label for="email">Email address</label>
                                <input type="email" class="form-control" name="email" placeholder="Enter your email">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" name="password" placeholder="Enter your Password">
                            </div>
                            <div class="form-group">
                                <label for="confirmpassword">Confirm Password</label>
                                <input type="password" class="form-control" name="confirmpassword" placeholder="Enter your Confirm Password">
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Registration Form</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
    