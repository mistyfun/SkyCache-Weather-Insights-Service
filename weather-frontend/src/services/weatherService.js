import axios from 'axios';
import React, { useEffect, useState } from 'react';

const API_URL = "http://localhost:8080/api/weather"; // adjust as per your backend

export const getCurrentWeather = (location) => {
  return axios.get(`${API_URL}/current`, { params: { location } });
};


