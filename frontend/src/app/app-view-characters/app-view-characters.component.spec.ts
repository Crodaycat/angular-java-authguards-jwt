import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppViewCharactersComponent } from './app-view-characters.component';

describe('AppViewCharactersComponent', () => {
  let component: AppViewCharactersComponent;
  let fixture: ComponentFixture<AppViewCharactersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppViewCharactersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppViewCharactersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
