package com.pillar.navtests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import com.pillar.pages.AttendeePage;

public class AttendeeNavigationTest extends BaseNavigationTest {
  private static final String ATTENDEE_PAGE_TITLE = "Attendee List";

  @Test
  public void canNavigateToAttendeePage() {
    AttendeePage attendeePage = homePage().navigateToAttendeePage();
    assertThat(attendeePage.getTitle(), is(ATTENDEE_PAGE_TITLE));
  }
}
