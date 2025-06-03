import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StationService {

  private stationGetALl = 'http://localhost:8080/station/getStations';
  private saveStation = 'http://localhost:8080/station/saveStation';
  private stationById = 'http://localhost:8080/station/getStationById';
  private updateStation = 'http://localhost:8080/station/updateStation';
  private deleteStation = 'http://localhost:8080/station/deleteStationById';


  constructor(private http:HttpClient) { }



public getAllStationData(active: any, stationName: any): Observable<any> {
  const params = new HttpParams()
    .set('active', active)
    .set('stationName', stationName);

  return this.http.get(this.stationGetALl, { params });
}

public saveStationData(obj:any):Observable<any>{
  return this.http.post(this.saveStation,obj);
}

public getStationDataById(id:any): Observable<any> {
  const params = new HttpParams()
    .set('id', id)
  return this.http.get(this.stationById, { params });
}

public updateStationData(obj:any):Observable<any>{
  return this.http.post(this.updateStation,obj);
}

public getDeleteStationById(id:any): Observable<any>{
const params = new HttpParams()
    .set('id', id)
  return this.http.get(this.deleteStation, { params });
}

}
