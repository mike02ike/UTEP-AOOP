/**
 * @author Ian Gutierrez & Erik LaNeave
 *         Date: 11/19/2023
 *         Course: CS 3331 - Advanced Object Oriented Programming
 *         Instructor: Dr. Daniel Mejia
 *         Programming Assignment 5
 *         Lab Description: This program is an extension of PA4, with added
 *         admin and customer functionality.
 *         Honesty Statement: I completed this work entirely on my own without
 *         any outside sources including peers, experts, online sources, or the
 *         like. The only assistance I received was from the instructor, TA, or
 *         IA.
 */

public class EventFactory {

  /**
   * Constructor
   */
  public EventFactory() {

  }

  /**
   * Creates appropriate event type
   * 
   * @param eventType Type of event
   * @return Appropriate type of event
   */
  public Event createEvent(String eventType) {
    switch (eventType) {
      case "Sport":
        return new Sport();

      case "Concert":
        return new Concert();

      case "Festival":
        return new Festival();

      default:
        return null;
    }
  }
}
