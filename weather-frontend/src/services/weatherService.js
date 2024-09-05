import axios from 'axios';

const API_URL = "http://localhost:8080/api/weather"; // adjust as per your backend

export const getCurrentWeather = (location) => {
  return axios.get(`${API_URL}/current`, { params: { location } });
};

export const getForecast = (location) => {
  return axios.get(`${API_URL}/forecast`, { params: { location } });
};

export const getHistoricalData = (location) => {
  return axios.get(`${API_URL}/historical`, { params: { location } });
};
