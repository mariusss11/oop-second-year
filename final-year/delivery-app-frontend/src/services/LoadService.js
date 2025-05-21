import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080";

export const fetchLoads = () => axios.get(REST_API_BASE_URL + '/api/load/all')

export const fetchDocs = () => axios.get(REST_API_BASE_URL + '/api/document/all')

export const fetchCargo = () => axios.get(REST_API_BASE_URL + '/api/cargo/all')