import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { PractiseComponent } from './practise/practise.component';
import { FormsModule } from '@angular/forms';
import { Practise2Component } from './practise2/practise2.component';
import { MicroComponent } from './micro/micro.component';
import { StationComponent } from './station/station.component';

@NgModule({
  declarations: [
    AppComponent,
    PractiseComponent,
    Practise2Component,
    MicroComponent,
    StationComponent
  ],
  imports: [
    BrowserModule,HttpClientModule,FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
