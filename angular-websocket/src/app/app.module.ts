import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MdListModule, MdSlideToggleModule } from '@angular/material';

import { AppComponent } from './app.component';
import { TaskListComponent } from './task-list/task-list.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { TaskService } from './task.service';
import { HttpModule } from '@angular/http';
import { StompConfig, StompService } from '@stomp/ng2-stompjs';

const stompConfig: StompConfig = {
  // Which server?
  url: 'ws://docker.localhost/ws/websocket',

  // Headers
  // Typical keys: login, passcode, host
  headers: {
    login: 'guest',
    passcode: 'guest'
  },

  // How often to heartbeat?
  // Interval in milliseconds, set to 0 to disable
  heartbeat_in: 0, // Typical value 0 - disabled
  heartbeat_out: 20000, // Typical value 20000 - every 20 seconds

  // Wait in milliseconds before attempting auto reconnect
  // Set to 0 to disable
  // Typical value 5000 (5 seconds)
  reconnect_delay: 5000,

  // Will log diagnostics on console
  debug: true
};

@NgModule({
  declarations: [
    AppComponent,
    TaskListComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MdListModule,
    HttpModule,
    MdSlideToggleModule,
    ReactiveFormsModule,
  ],
  providers: [
    TaskService,
    StompService,
    {
      provide: StompConfig,
      useValue: stompConfig
    }
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
