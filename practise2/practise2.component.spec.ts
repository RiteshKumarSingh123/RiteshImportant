import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Practise2Component } from './practise2.component';

describe('Practise2Component', () => {
  let component: Practise2Component;
  let fixture: ComponentFixture<Practise2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Practise2Component ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Practise2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
