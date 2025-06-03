import { TestBed } from '@angular/core/testing';

import { Practise2Service } from './practise2.service';

describe('Practise2Service', () => {
  let service: Practise2Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Practise2Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
