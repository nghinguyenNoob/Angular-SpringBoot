import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
    providedIn: 'root',
})
export class PollService {

    private baseUrl = 'http://localhost:8080/';
    constructor(private http: HttpClient) { }

    getListPoll(): Observable<any> {
        return this.http.get(`${this.baseUrl}` + 'pollresponse-list'); // poll-list
    }

    getListOptionPoll(): Observable<any> {
        return this.http.get(`${this.baseUrl}` + 'optionpoll-list');
    }

    getListOptionPollDetail(): Observable<any> {
        return this.http.get(`${this.baseUrl}` + 'optionpolldetail-list');
    }

    getListTopVote(): Observable<any> {
        return this.http.get(`${this.baseUrl}` + 'topvotes-list');
    }

    deletePoll(idPoll: any): Observable<any> {
        return this.http.delete(`${this.baseUrl}` + `poll-delete/${idPoll}`)
    }

    getPollPagination(request): Observable<any> {
        const params = request;
        return this.http.get(`${this.baseUrl}` + 'pageable', { params });
    }

    savePoll(poll: any): Observable<any> {
        return this.http.post(`${this.baseUrl}` + 'save-poll', poll);
    }
}