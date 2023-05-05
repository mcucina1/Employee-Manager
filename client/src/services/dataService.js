import axios from 'axios'

const SERVER_ADDRESS = 'http://localhost:4567/api/'

export function getQualification(name) {
    return axios.get(SERVER_ADDRESS + 'qualifications/' + name).then((res) => JSON.parse(res.request.response))
}

export function getQualifications() {
    return axios.get(SERVER_ADDRESS + 'qualifications').then((res) => JSON.parse(res.request.response).sort((a, b) => a.description.localeCompare(b.description)))
}

export function createQualification(description) {
    return axios.post(SERVER_ADDRESS + 'qualifications/' + description, { description: description })
}

export function getWorker(name) {
    return axios.get(SERVER_ADDRESS + 'workers/' + name).then((res) => JSON.parse(res.request.response))
}

export function getWorkers() {
    return axios.get(SERVER_ADDRESS + 'workers').then((res) => JSON.parse(res.request.response).sort((a, b) => a.name.localeCompare(b.name)))
}

export function createWorker(request) {
    return axios.post(SERVER_ADDRESS + 'workers/' + request.name, request)
}

export function getProjects() {
    return axios.get(SERVER_ADDRESS + 'projects').then((res) => JSON.parse(res.request.response).sort((a, b) => a.name.localeCompare(b.name)))
} 

export function assignWorker(request){
    return axios.put(SERVER_ADDRESS + 'assign', request)
    
}

export function unassignWorker(request){
    return axios.put(SERVER_ADDRESS + 'unassign', request)
}

export function startProject(request){
    return axios.put(SERVER_ADDRESS + 'start', request)
}

export function finishProject(request){
    return axios.put(SERVER_ADDRESS + 'finish', request)
}

export function createProject(request){
    return axios.post(SERVER_ADDRESS + 'project/' +  request.name, request)
}