import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeadTrackingComponent } from './lead-tracking.component';

describe('LeadTrackingComponent', () => {
  let component: LeadTrackingComponent;
  let fixture: ComponentFixture<LeadTrackingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LeadTrackingComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LeadTrackingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
