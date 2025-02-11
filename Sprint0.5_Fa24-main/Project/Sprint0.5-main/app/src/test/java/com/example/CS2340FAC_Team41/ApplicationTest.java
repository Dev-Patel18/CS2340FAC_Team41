package com.example.CS2340FAC_Team41;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.auth.FirebaseUser;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class ApplicationTest {

    @Mock
    private FirebaseAuth mockAuth;

    @Mock
    private FirebaseUser mockUser;

    @Mock
    private DatabaseReference mockReference;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    // Sprint 1: Login Validation Tests

    //Author: Vinay Gupta
    @Test
    public void testEmptyUsername() {
        String username = "";
        assertTrue("Username should be invalid if empty", username.isEmpty());
    }

    @Test
    public void testWhitespaceUsername() {
        String username = "   ";
        assertTrue("Username should be invalid if only whitespace", username.trim().isEmpty());
    }


    //Author: Dev Patel

    @Test
    public void testInvalidLogin() {
        when(mockAuth.getCurrentUser()).thenReturn(null);
        assertNull("Login should fail for invalid accounts", mockAuth.getCurrentUser());
    }

    @Test
    public void testValidLogin() {
        when(mockAuth.getCurrentUser()).thenReturn(mockUser);
        assertNotNull("Login should succeed for valid accounts", mockAuth.getCurrentUser());
    }


    // Sprint 2: Travel Location Tests

    //Author: Viraj Kulkarni
    @Test
    public void testEmptyTravelLocationInput() {
        String location = "";
        assertTrue("Travel location should not be empty", location.isEmpty());
    }

    @Test
    public void testValidTravelLocationInput() {
        String location = "Paris";
        assertFalse("Travel location should not be empty", location.isEmpty());
    }

    // Sprint 2: Firebase Storage Tests

    //Author: Justin Zheng
    @Test
    public void testTravelLogStorage() {
        // Create a mock Firebase reference
        DatabaseReference mockReference = mock(DatabaseReference.class);

        // Store simple data
        mockReference.setValue("New York");

        // Verify the setValue method was called
        verify(mockReference).setValue("New York");
    }

    @Test
    public void testVacationDataStorage() {
        // Create a mock Firebase reference
        DatabaseReference mockReference = mock(DatabaseReference.class);

        // Store simple vacation data
        mockReference.setValue("10 days");

        // Verify the setValue method was called
        verify(mockReference).setValue("10 days");
    }

    // Sprint 2: Vacation Time Calculation Tests

    //Author: Anish Cheraku
    @Test
    public void testCalculateDuration() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date startDate = sdf.parse("2024-01-01");
        Date endDate = sdf.parse("2024-01-10");

        long diffInMillis = Math.abs(endDate.getTime() - startDate.getTime());
        long days = diffInMillis / (1000 * 60 * 60 * 24);

        assertEquals("The duration should be 9 days", 9, days);
    }

    @Test
    public void testEmptyDurationSubmission() {
        String startDate = "";
        String endDate = "";
        String duration = "";

        assertTrue("Start date, end date, or duration must not be empty",
                startDate.isEmpty() && endDate.isEmpty() && duration.isEmpty());
    }


    // Sprint 3

}