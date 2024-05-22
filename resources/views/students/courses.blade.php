<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <title>Enrolled Students</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="{{asset('vendor/bootstrap/css/bootstrap.min.css')}}" rel="stylesheet">
  <link href="{{asset('vendor/bootstrap-icons/bootstrap-icons.css')}}" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="{{asset('css/style.css')}}" rel="stylesheet">
</head>
<body>
  <header id="header" class="d-flex align-items-center">
    <div class="container d-flex align-items-center" id="includeHtml">@include('header')</div> 
    <!-- "/*@*/include" to include a specific file in any part of the code as if it was there -->
  </header><!-- End Header -->
<main id="main">
    <div class="container">
        <h1>Students with Enrolled Courses</h1>
        <div class="table-responsive">
          <table>
            <thead>
              <tr>
                <th>Student</th>
                <th>Title</th>
                <th>Description</th>
              </tr>
            </thead>
            <tbody>
            @foreach ($students as $student)
            @foreach ($student->courses as $course)
              <tr>
                <td>{{ $student->name }}</td>
                <td>{{ $course->title }}</td>
                <td>{{ $course->description }}</td>
              </tr>
              @endforeach
              @endforeach
            </tbody>
          </table>
        </div>
      </div>
</main>
<footer id="footer">
  <div class="container">
    <div class="copyright">
      &copy; Copyright <strong><span>IT 106</span></strong>. All Rights Reserved
    </div>
  </div>
</footer>

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>
</body>
</html>
