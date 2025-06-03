import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class MicroService {

  private AllListUrl = 'http://localhost:9999/dept/getAllDatas';

  private saveUrl = 'http://localhost:9999/dept/saveShowRoom';

  private getById = 'http://localhost:9999/dept/getDataById?';

  private deleteUrl = 'http://localhost:9999/dept/deleteAllInfoById?';

  private updateUrl = 'http://localhost:9999/dept/updateDepartment';

  private updateShow = 'http://localhost:9999/dept/updateShowRoom';

  private teacherList = 'http://localhost:9999/dept/getTeachersList';

  private saveTeacher = 'http://localhost:9999/dept/saveTeachersData';

  private getTeacherById = 'http://localhost:9999/dept/getTeacherById?';

  private updateTeacher = 'http://localhost:9999/dept/updateTeacher';

  private deleteTeacher = 'http://localhost:9999/dept/deleteTeacherById?';

  constructor(private http:HttpClient) { }

  public getAllMicroList():Observable<any>{
  return  this.http.get(this.AllListUrl);
  }

  public saveMicro(obj:any):Observable<any>{
   return this.http.post(this.saveUrl,obj);
  }

  public getMicroById(showRoomId:any):Observable<any>{
    const params = new HttpParams().set('showRoomId', showRoomId.toString());
    return this.http.get(this.getById,{params});
  }

  public deleteMicroById(showRoomId:any):Observable<any>{
    const params = new HttpParams().set('showRoomId', showRoomId.toString());
    return this.http.get(this.deleteUrl,{params});
  }

  public updateMicro(obj:any):Observable<any>{
    return this.http.post(this.updateUrl,obj);
  }

  public updateShowRoom(obj:any):Observable<any>{
    return this.http.post(this.updateShow,obj);
  }

  public getTeacherLists():Observable<any>{
    return this.http.get(this.teacherList);
  }

  public saveTeachers(obj:any):Observable<any>{
    return this.http.post(this.saveTeacher,obj);
  }

  public getTeacherByIds(id:any):Observable<any>{
   const params = new HttpParams().set('id',id.toString());
  return this.http.get(this.getTeacherById,{params});
  }

  public updateTeachers(obj:any):Observable<any>{
    return this.http.post(this.updateTeacher,obj);
  }

  public deleteTeachers(id:any):Observable<any>{
    const params = new HttpParams().set('id',id.toString());
    return this.http.get(this.deleteTeacher,{params});
  }

}
