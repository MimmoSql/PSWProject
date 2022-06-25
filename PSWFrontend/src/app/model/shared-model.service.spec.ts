import { TestBed } from '@angular/core/testing';

import { SharedModelService } from './shared-model.service';

describe('ShareModelService', () => {
  let service: SharedModelService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SharedModelService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
