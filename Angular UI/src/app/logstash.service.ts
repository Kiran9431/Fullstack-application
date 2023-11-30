import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LogstashService {

  private logstashEndpoint = 'http://192.168.1.46:'

  constructor(private http: HttpClient) { }

  log(message: string): void {
    const logEntry = { timestamp: new Date().toISOString(), message };
    this.http.post(this.logstashEndpoint, logEntry).subscribe(
      () => console.log('Log sent successfully'),
      (error) => console.error('Error sending log:', error)
    );
  }
}
