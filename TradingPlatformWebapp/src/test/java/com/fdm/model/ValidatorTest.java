package com.fdm.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ValidatorTest
{
    Validator val;

    @Before
    public void setUp() throws Exception
    {
        val = new Validator();
    }

//    @Test
//    public void test()
//    {
//        fail("Not yet implemented");
//    }
    
    @Test
    public void testCheckUsernameReturnsTrueForValidUsernameComposedOnlyOfLowerCaseCharacters()
    {
        assertTrue(val.checkUsername("bob"));
    }
    
    @Test
    public void testCheckUsernameReturnsFalseForInvalidUsernameContainingABlank()
    {
        assertFalse(val.checkUsername("bo ob"));
    }
    
    @Test
    public void testCheckUsernameReturnsTrueForValidUsernameComposedOfLowerAndUpperCaseCharactersOnly()
    {
        assertTrue(val.checkUsername("Alice"));
    }
    
    @Test
    public void testCheckUserReturnsFalseForInvalidUsernameContainingASpecialCharacter()
    {
        assertFalse(val.checkUsername("bob!"));
        assertFalse(val.checkUsername("$bob"));
        assertFalse(val.checkUsername("Ali&ce"));
        assertFalse(val.checkUsername("A£li)c*e"));
    }
    
    @Test
    public void testCheckUserReturnsFalseForEmptyUserName()
    {
        assertFalse(val.checkUsername(""));
    }
    
    @Test
    public void testCheckUserReturnsTrueForUsernameContainingOnlyNumbersAndCharacters()
    {
        assertTrue(val.checkUsername("Alice12345"));
    }
    
    //---------------------------------------------------------------------------------------

    @Test
    public void testCheckPasswordReturnsFalseForEmptyPassword()
    {
        assertFalse(val.checkPassword(""));
    }
    
    @Test
    public void testCheckPasswordReturnsTrueIfProperPasswordContainingAtLeastOneUpperAndLowerCaseCharacterTwoSpecialCharactersAndOneNumberAndHasAtLeastLengthEightButIsNotLongerThanTwentyFour()
    {
        assertTrue(val.checkPassword("Test12345()"));
    }
    
    @Test
    public void testCheckPasswordReturnsFalseIfProperPasswordMissingOnlyAnUpperCaseCharacterIsChecked()
    {
        assertFalse(val.checkPassword("test12345()"));
    }
    
    @Test
    public void testCheckPasswordReturnsFalseIfProperPasswordMissingOnlyAnLowerCaseCharacterIsChecked()
    {
        assertFalse(val.checkPassword("TEST12345()"));
    }
    
    @Test
    public void testCheckPasswordReturnsFalseIfProperPasswordHavingOnlyOneSpecialCharacterIsChecked()
    {
        assertFalse(val.checkPassword("Test12345*"));
    }
    
    @Test
    public void testCheckPasswordReturnsFalseIfProperPasswordHavingNoSpecialCharacterIsChecked()
    {
        assertFalse(val.checkPassword("Test12345"));
    }
    
    @Test
    public void testCheckPasswordReturnsFalseIfProperPasswordHavingNoNumbersIsChecked()
    {
        assertFalse(val.checkPassword("Test!£$%^&*()"));
    }
    
    @Test
    public void testCheckPasswordReturnsFalseIfProperPasswordWhichIsTooShortIsChecked()
    {
        assertFalse(val.checkPassword("Te1$%"));
    }
    
    @Test
    public void testCheckPasswordReturnsFalseIfProperPasswordWhichIsTooLongIsChecked()
    {
        assertFalse(val.checkPassword("ThisIsAVeryLongTestPassword1234567890^&*()"));
    }
}
