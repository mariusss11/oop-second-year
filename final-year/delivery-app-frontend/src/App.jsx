import { useState } from 'react'
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom'
import './App.css'
import HomePageComponent from './components/HomePageComponent';


function App() {
  return (
    <>
    <BrowserRouter>
      <Routes>

        <Route path='/' element={<HomePageComponent/>}></Route>

      </Routes>
    </BrowserRouter>
    </>
  )
}

export default App
