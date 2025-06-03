import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class Practise2Service {

  private getShowRoomList = 'http://localhost:8080/showRoom/getShowRoomList';

  private getAllShowRoomDataUrl = 'http://localhost:8080/showRoom/getShowRoomData';

  private saveShowRoomUrl = 'http://localhost:8080/showRoom/saveShowRoom';

  constructor(private http:HttpClient) { }

  public getShowRoom():Observable<any>{
    return this.http.get<any>(this.getShowRoomList);
  }

  public getAllShowRoom():Observable<any>{
    return this.http.get<any>(this.getAllShowRoomDataUrl);
  }

  public saveShowRoomData(obj:any):Observable<any>{
    return this.http.post(this.saveShowRoomUrl,obj);
  }
  
}
