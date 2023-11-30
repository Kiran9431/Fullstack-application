import { Component } from '@angular/core';
import { LogstashService } from './logstash.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  template: '<button (click)="log()">Log Message</button>'
})
export class AppComponent {
  title = 'Employee Management System';

  constructor(private logstashService: LogstashService) {}

  log(): void {
    this.logstashService.log('This is a log message from Angular.');
  }

}
