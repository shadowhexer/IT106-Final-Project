<html>
  
<link href="{{asset('css/header.css')}}" rel="stylesheet">

<a href="index.html" class="logo me-auto"><img src="" alt="" class="img-fluid"></a>

<nav id="navbar" class="navbar" style="margin-right: 80px">
    <ul>
      {{-- <li><a href="team.html">Home</a></li> --}}
      <li><a href="{{route('courses')}}">Course</a></li>
      <li><a href="{{route('students')}}">Student</a></li>
      <li><a href="{{route('enrolled')}}">Enrolled Students </a></li>
      </li>

    </ul>
    <i class="bi bi-list mobile-nav-toggle"></i>
  </nav><!-- .navbar -->

</html>