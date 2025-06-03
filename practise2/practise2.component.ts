import { Component, OnInit } from '@angular/core';
import { Practise2Service } from '../practise2.service';
@Component({
  selector: 'app-practise2',
  templateUrl: './practise2.component.html',
  styleUrls: ['./practise2.component.css']
})
export class Practise2Component implements OnInit {

  listOfShowRoom :any[] = [];
  kawasakiListData :any[] = [];
  tvsListData :any[] = [];
  bajajListData :any[] = [];
  yamahaListData :any[] = [];
  heroListData :any[] = [];
  hondaListData :any[]=[];
  showRoomListData :any[] = [];
  showRoomName : any;
  showRoomOwnerName : any;
  totalEmployess : any;
  hCompanyFrom : any;
  hManagerName : any;
  hBestModel : any;
  hOcompanyFrom : any;
  hOmanagerName : any;
  hObestModel : any;
  bCompanyFrom : any;
  bManagerName : any;
  bBestModel : any;
  kCompanyFrom : any;
  kManagerName : any;
  kBestModel : any;
  tCompanyFrom : any;
  tManagerName : any;
  tBestModel : any;
  yCompanyFrom : any;
  yManagerName : any;
  yBestModel : any;


  constructor(private service:Practise2Service) {
    this.getListofShowRoomData();
    this.getAllShowRoomListData();
   }

  ngOnInit(): void {
  }

  public getListofShowRoomData(){
    this.service.getShowRoom().subscribe(data=>{
      this.listOfShowRoom = data;
      console.log(data);
    })
  }

  public getAllShowRoomListData(){
    return this.service.getAllShowRoom().subscribe(listOfData=>{
      console.log(listOfData);
      this.kawasakiListData = listOfData.kawasakiList;
      this.tvsListData = listOfData.tvsList;
      this.bajajListData = listOfData.bajajList;
      this.yamahaListData = listOfData.yamahaList;
      this.heroListData = listOfData.heroList;
      this.hondaListData = listOfData.hondaList;
      this.showRoomListData = listOfData.showRoomList;
    })
  }

  public saveAllData(){
  const  obj={
    showRoomName:this.showRoomName,
    showRoomOwnerName:this.showRoomOwnerName,
    totalEmployess:this.totalEmployess,
    "heroList":[{
        companyFrom:this.hCompanyFrom,
        managerName:this.hManagerName,
        bestModel:this.hBestModel
    }],
    "bajajList":[{
        companyFrom:this.bCompanyFrom,
        managerName:this.bManagerName,
        bestModel:this.bBestModel
    }],
    "hondaList":[{
      companyFrom:this.hOcompanyFrom,
      managerName:this.hOmanagerName,
      bestModel:this.hObestModel
    }],
    "kawasakiList":[{
      companyFrom:this.kCompanyFrom,
      managerName:this.kManagerName,
      bestModel:this.kBestModel
    }],
    "tvsList":[{
      companyFrom:this.tCompanyFrom,
      managerName:this.tManagerName,
      bestModel:this.tBestModel
    }],
    "yamahaList":[{
      companyFrom:this.yCompanyFrom,
      managerName:this.yManagerName,
      bestModel:this.yBestModel
    }]
}
return this.service.saveShowRoomData(obj).subscribe(data=>{
  console.log(data);
   this.getListofShowRoomData();
    this.getAllShowRoomListData();
})
  }

}
