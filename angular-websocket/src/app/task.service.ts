import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Task } from './task';

@Injectable()
export class TaskService {
  apiUrl = 'http://docker.localhost/checklist/api/tasks';

  constructor(private http: Http) { }

  save(task: Task) {
    return this.http.put(this.apiUrl, task);
  }

  query() {
    return this.http.get(this.apiUrl);
  }
}
