import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PractiseService {
// private url ='http://localhost:8080/hitachi/getAllHitachi';

private bikeList = 'http://localhost:8080/bike/getBikeList';

private saveBike = 'http://localhost:8080/bike/insertBike';

private getBikeById = 'http://localhost:8080/bike/getBikeById?';

private deleteUrl = 'http://localhost:8080/bike/deleteById?';

  constructor(private http:HttpClient) {
   }

  // getList():Observable<any>{
  //   return this.http.get<any>(this.url);
  // }

  getBikeList():Observable<any>{
    return this.http.get<any>(this.bikeList);
  }

  saveBikeData(obj:any):Observable<any>{
    return this.http.post(this.saveBike,obj);
  }

  getbikeId(id:any):Observable<any>{
     const params = new HttpParams().set('id', id.toString());
    //  return this.http.get(this.getBikeById+id);
     return this.http.get(this.getBikeById, { params });
  }

  deleteUsingId(id:any):Observable<any>{
    const params = new HttpParams().set('id', id.toString());
    // return this.http.get(this.deleteUrl+id);
    return this.http.get(this.deleteUrl, { params });
  }

}
