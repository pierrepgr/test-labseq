import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, take } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LabseqService {

  constructor(private http: HttpClient) { }

  calculate(number: string): Observable<any> {
    return this.http.get(`http://localhost:8080/api/labseq/${number}`, { responseType: 'text' }).pipe(take(1));
  }
}
