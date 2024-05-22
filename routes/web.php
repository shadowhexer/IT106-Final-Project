<?php

use Illuminate\Support\Facades\Route;

use App\Http\Controllers\StudentController;
use App\Http\Controllers\CourseController;

Route::get('/', [StudentController::class, 'index'])->name('students');
Route::get('/students', [StudentController::class, 'index'])->name('students');
Route::get('/courses', [CourseController::class, 'index'])->name('courses');
Route::get('/enrolled', [StudentController::class, 'studentsWithCourses'])->name('enrolled');
