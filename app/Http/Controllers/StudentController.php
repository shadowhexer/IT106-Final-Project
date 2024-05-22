<?php

namespace App\Http\Controllers;

use App\Models\Student; 
use Illuminate\Http\Request;

class StudentController extends Controller
{
    public function index()
    {
        $students = Student::all();
        return view('students.index', compact('students'));
    }

    public function studentsWithCourses()
    {
        $students = Student::with('courses')->get();
        return view('students.courses', compact('students'));
    }

}
